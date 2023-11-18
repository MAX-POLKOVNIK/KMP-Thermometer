import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
		SearchDevicesScreenView(viewModel: SearchDevicesViewModel())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
