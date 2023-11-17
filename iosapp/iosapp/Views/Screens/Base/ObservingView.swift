//
//  ObservingView.swift
//  iosapp
//
//  Created by Max Polkovnik on 17/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine
import SwiftUI

public struct ObservingView<State : ViewModelState, StateView>: View where StateView: View {

    @ObservedObject private var observableState: ObservableViewModelState<State>

    private let viewProducer: (State) -> StateView

    public init(
        publisher: AnyPublisher<State, Never>,
        @ViewBuilder viewProducer: @escaping (State) -> StateView
    ) {
        self.observableState = ObservableViewModelState(publisher: publisher)
        self.viewProducer = viewProducer
    }

    public var body: some View {
        let view: AnyView
        
        if let state = self.observableState.value {
            view = AnyView(viewProducer(state))
        } else {
            view = AnyView(EmptyView())
        }
        
        return view
    }
}
