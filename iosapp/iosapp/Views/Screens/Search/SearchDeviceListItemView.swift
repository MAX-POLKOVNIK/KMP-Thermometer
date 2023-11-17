//
//  SearchDeviceListItemView.swift
//  iosapp
//
//  Created by Max Polkovnik on 17/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchDeviceListItemView: View {
    private let state: SearchDevicesListItem
    
    init(_ state: SearchDevicesListItem) {
        self.state = state
    }
    
    var body: some View {
        HStack {
            Image(systemName: "thermometer.sun.circle.fill")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 48, height: 48)
                .padding(.leading)
                .foregroundColor(Color(state.textColor.toUIColor()))
            
            VStack(alignment: .leading) {
                Text(state.deviceName)
                    .font(.system(size: 16))
                    .foregroundColor(Color(state.textColor.toUIColor()))
                Text(state.deviceDescription)
                    .font(.system(size: 16))
                    .foregroundColor(Color(state.textColor.toUIColor()))
                if state.isDeviceBatteryVisible {
                    Text(state.deviceBattery)
                        .font(.system(size: 14))
                        .foregroundColor(Color(state.textColor.toUIColor()))
                }
            }
            
            Spacer()
            
            ButtonView(state.disconnectButtonState)
                .frame(width: 80)
        }
    }
}

#Preview {
    SearchDeviceListItemView(
        SearchDevicesListItem.companion.Preview
    )
}

extension SearchDevicesListItem: Identifiable {
    
}
