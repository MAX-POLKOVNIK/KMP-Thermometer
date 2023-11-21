//
//  FlowPublisher.swift
//  iosapp
//
//  Created by Max Polkovnik on 17/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

//public struct FlowPublisher<T : ViewModelState> : Publisher {
//    public typealias Output = T
//    public typealias Failure = Never
//    
//    private let flow: ViewModelStateFlow<T>
//    
//    init(of flow: ViewModelStateFlow<T>) {
//        self.flow = flow
//    }
//    
//    public func receive<S>(subscriber: S)
//        where S : Subscriber, Never == S.Failure, T == S.Input {
//            
//        let subscription = FlowSubscription(flow, subscriber: subscriber)
//        subscriber.receive(subscription: subscription)
//    }
//    
//    private final class FlowSubscription<S: Subscriber> : Subscription
//        where S.Input == T, S.Failure == Failure {
//        
//        private var flow: ViewModelStateFlow<T>?
//        private var subscriber: S?
//        private var closeable: ViewModelStateFlowCloseable?
//        
//        init(_ flow: ViewModelStateFlow<T>, subscriber: S) {
//            self.flow = flow
//            self.subscriber = subscriber
//            
//            closeable = flow.watch { next in
//                _ = subscriber.receive(next)
//            }
//        }
//        
//        func cancel() {
//            closeable?.close()
//            closeable = nil
//            flow = nil
//            subscriber = nil
//        }
//        
//        func request(_ demand: Subscribers.Demand) {}
//    }
//}

func FlowPublisher<T>(_ flow: ViewModelStateFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        
        let closable = flow.watch { next in
            subject.send(next)
        }
        
        return subject.handleEvents(
            receiveCancel: {
                closable.close()
            }
        )
    }.eraseToAnyPublisher()
}

func FlowPublisher<T>(_ flow: ViewModelSideEffectFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T, Never>>> {
        let subject = PassthroughSubject<T, Never>()
        
        let closable = flow.watch { next in
            subject.send(next)
        }
        
        return subject.handleEvents(
            receiveCancel: {
                closable.close()
            }
        )
    }.eraseToAnyPublisher()
}
