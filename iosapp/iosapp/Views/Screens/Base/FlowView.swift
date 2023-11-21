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

public struct FlowView<State: ViewModelState, SideEffect: ViewModelSideEffect, StateView>: View where StateView: View {

    @ObservedObject private var observableState: ObservableViewModelState<State>
    @ObservedObject private var observableSideEffect: ObservableViewModelSideEffect<SideEffect>

    private let viewProducer: (State, SideEffect?) -> StateView

    public init(
        of flow: ViewModelStateFlow<State>,
        and sideEffectFlow: ViewModelSideEffectFlow<SideEffect>,
        @ViewBuilder viewProducer: @escaping (State, SideEffect?) -> StateView
    ) {
        self.observableState = 
            ObservableViewModelState(publisher: FlowPublisher(flow))
        
        self.observableSideEffect =
            ObservableViewModelSideEffect(publisher: FlowPublisher(sideEffectFlow))
        
        self.viewProducer = viewProducer
    }

    public var body: some View {
        let view: AnyView
        
        if let state = self.observableState.value {
            view = AnyView(viewProducer(state, self.observableSideEffect.value))
        } else {
            view = AnyView(EmptyView())
        }
        
        return view
    }
}
