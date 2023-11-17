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
    
    @ObservedObject var state: ObservableViewModelState<SearchDeviceViewModelState>
    
    init(viewModel: SearchDevicesViewModel) {
        self.viewModel = viewModel
        state = ObservableViewModelState(
            publisher: FlowPublisher(viewModel.state)
        )
    }
    
    var body: some View {
        ObservingView(
            publisher: FlowPublisher(viewModel.state)
        ) { state in
            SearchDevicesStateView(state)
        }
    }
}



struct SearchDevicesStateView: View {
    private let state: SearchDeviceViewModelState
    
    init(_ state: SearchDeviceViewModelState) {
        self.state = state
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
    }
}

#Preview {
    SearchDevicesStateView(
        SearchDeviceViewModelState.companion.Preview
    )
}
