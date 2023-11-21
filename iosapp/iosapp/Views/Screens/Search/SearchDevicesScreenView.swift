//
//  SearchDevicesScreenView.swift
//  iosapp
//
//  Created by Max Polkovnik on 17/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchDevicesScreenView: View {
    private let viewModel: SearchDevicesViewModel
    
    init(viewModel: SearchDevicesViewModel = SearchDevicesViewModel()) {
        self.viewModel = viewModel
    }
    
    var body: some View {
        FlowView(of: viewModel.state, and: viewModel.sideEffect) {
            SearchDevicesStateView($0, $1)
        }
    }
}

struct SearchDevicesStateView: View {
    private let state: SearchDeviceViewModelState
    private let sideEffect: SearchDevicesViewModelSideEffect?
    
    @State private var toast: Toast?
    
    init(
        _ state: SearchDeviceViewModelState,
        _ sideEffect: SearchDevicesViewModelSideEffect?
    ) {
        self.state = state
        self.sideEffect = sideEffect
        print((sideEffect as? SearchDevicesViewModelSideEffectToast)?.toast)
        self.toast = (sideEffect as? SearchDevicesViewModelSideEffectToast)?.toast
    }
    
    var body: some View {
        VStack {
            HStack {
                Image(systemName: "arrow.backward")
                    .foregroundColor(.white)
                    .padding()
                
                Text(state.toolbarTitle)
                    .foregroundStyle(.white)
                
                Spacer()
            }.background(Color(shared.Color.companion.Primary.toUIColor()))
                .frame(maxWidth: .infinity)
            
            HStack {
                Text(state.thermometersTitle)
                    .padding()
                if state.isSearchingIndicatorVisible {
                    ProgressView()
                        .padding(.vertical)
                }
            
                Spacer()
            }
            
            List(state.deviceList) { item in
                SearchDeviceListItemView(item)
                    .listRowInsets(
                        EdgeInsets(
                            top: 8,
                            leading: 0,
                            bottom: 8,
                            trailing: 0
                        )
                    )
                    .listRowSeparator(.hidden)
            }.listStyle(.plain)
            
            Spacer()
            
            ButtonView(state.searchButton)
                .padding()
        }
        .toastView(toast: $toast)
    }
}

#Preview {
    SearchDevicesStateView(
        SearchDeviceViewModelState.companion.Preview,
        nil
    )
}
