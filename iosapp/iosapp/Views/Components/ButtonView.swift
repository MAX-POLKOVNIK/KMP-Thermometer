//
//  Button.swift
//  iosapp
//
//  Created by Max Polkovnik on 17/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ButtonView: View {
    private let state: ButtonState
    
    init(_ state: ButtonState) {
        self.state = state
    }
    
    var body: some View {
        Button(
            action: state.onClick,
            label: {
                Text(state.text)
                    .frame(minWidth: 0, maxWidth: .infinity)
                    .padding()
                    .foregroundColor(Color(state.textColor.toUIColor()))
                    .overlay(
                        RoundedRectangle(cornerRadius: CGFloat(state.cornerRadius))
                            .stroke(Color(state.outlineColor.toUIColor()), lineWidth: 1)
                )
            }
        )
            .background(Color(state.backgroundColor.toUIColor())) // If you have this
            .cornerRadius(CGFloat(state.cornerRadius))
            .disabled(!state.isEnabled)
    }
}

struct ButtonView_Previews: PreviewProvider {
    static var previews: some View {
        VStack {
            ButtonView(ButtonState.companion.Blue(text: "Hello", onClick: {} ))
            ButtonView(ButtonState.companion.BlueDisable(text: "Hello"))
            ButtonView(ButtonState.companion.BlueOutline(text: "Hello", onClick: {} ))
            ButtonView(ButtonState.companion.BlueOutlineDisabled(text: "Hello"))
            ButtonView(ButtonState.companion.BlueTextOnly(text: "Hello", onClick: {} ))
            ButtonView(ButtonState.companion.BlueTextOnlyDisabled(text: "Hello"))
        }
    }
}
