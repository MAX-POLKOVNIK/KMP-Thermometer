//
//  ObservableViewModelSideEffect.swift
//  iosapp
//
//  Created by Max Polkovnik on 18/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI
import Combine

class ObservableViewModelSideEffect<T : ViewModelSideEffect>: ObservableObject {
    @Published var value: T?

    init(publisher: AnyPublisher<T, Never>) {
        publisher
            .compactMap { $0 }
            .receive(on: DispatchQueue.main)
            .assign(to: &$value)
    }
}
