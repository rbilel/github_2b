import java.io.*;
import java.net.*;

class UDPClient {
	public static void main(String args[]) throws Exception {
		try {
			// Hostname
			String serverHostname = new String("127.0.0.1");

			if (args.length > 0)
				serverHostname = args[0];
			// 1 - Creation du buffer de lecture clavier

			BufferedReader inFromUser = new BufferedReader(
					new InputStreamReader(System.in));
			// 2 - Creation de la socket, n de port par defaut
			DatagramSocket clientSocket = new DatagramSocket();
			// 3 - Recuperation de l'@IP du serveur
			InetAddress IPAddress = InetAddress.getByName(serverHostname);
			System.out.println("Attemping to connect to " + IPAddress
					+ ") via UDP port 9876");
			// 3bis - preparation de l'echange

			byte[] sendData = new byte[7];
			byte[] receiveData = new byte[7];

			System.out.print("Enter Message: ");
			String sentence = inFromUser.readLine();
			sendData = sentence.getBytes();

			System.out.println("Sending data to " + sendData.length
					+ " bytes to server.");
			// 3ter - Initialisation de la (UDP)PDU a emettre
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, 9876);
			// 4 - Emission de la (UDP)PDU
			clientSocket.send(sendPacket);
			// 5 - Creation d'un buffer de (UDP)PDU arrivant sur la socket
			DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);

			System.out.println("Waiting for return packet");
			clientSocket.setSoTimeout(10000);

			try {
				// 5bis - Reception de la (UDP)PDU
				clientSocket.receive(receivePacket);
				// 6 - Affichage des donnees recues
				String modifiedSentence = new String(receivePacket.getData());

				InetAddress returnIPAddress = receivePacket.getAddress();

				int port = receivePacket.getPort();

				System.out.println("From server at: " + returnIPAddress + ":"
						+ port);
				System.out.println("Message: " + modifiedSentence);

			} catch (SocketTimeoutException ste) {
				System.out.println("Timeout Occurred: Packet assumed lost");
			}
			// Fermeture de la socket
			clientSocket.close();
		} catch (UnknownHostException ex) {
			System.err.println(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
