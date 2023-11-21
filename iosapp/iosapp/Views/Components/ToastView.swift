//
//  ToastView.swift
//  iosapp
//
//  Created by Max Polkovnik on 18/11/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ToastView: View {
    let text: String
    
    init(_ text: String) {
        self.text = text
    }
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack(alignment: .top) {
                Spacer(minLength: 10)
                
                VStack(alignment: .center) {
                    Text(text)
                        .foregroundStyle(Color.white)
                        .font(.system(size: 14, weight: .semibold))
                        .multilineTextAlignment(.center)
                }
                
                Spacer(minLength: 10)
                
            }
            .padding()
        }
        .background(Color.black)
        .frame(minWidth: 0, maxWidth: .infinity)
        .cornerRadius(8)
        .shadow(color: Color.black.opacity(0.25), radius: 4, x: 0, y: 1)
        .padding(.horizontal, 16)
    }
}

#Preview {
    ToastView("Some toast. Based on the code above, the toast consists of icons")
}
