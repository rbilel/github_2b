import java.io.*;
import java.net.*;

class UDPServer {
	public static void main(String args[]) throws Exception {
		try {
			// Creation d'une socket sur le port 9876. Le serveur attend sur ce
			// port
			DatagramSocket serverSocket = new DatagramSocket(9876);

			byte[] receiveData;
			byte[] sendData = new byte[7];

			while (true) {

				receiveData = new byte[7];
				// Traitement de la reception
				// Creation d'un buffer de (UDP)PDU arrivant sur la socket
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);

				System.out.println("Waiting for datagram packet");
				// Reception d'un (UDP)PDU sur la socket

				serverSocket.receive(receivePacket);

				String sentence = new String(receivePacket.getData());
				// Recuperation de l'adresse IP de l'emetteur
				InetAddress IPAddress = receivePacket.getAddress();
				// Recuperation du n de port de l'emetteur
				int port = receivePacket.getPort();

				System.out.println("From: " + IPAddress + ":" + port);
				System.out.println("Message: " + sentence);
				// Transformer le message reçu en majuscule
				String capitalizedSentence = sentence.toUpperCase();
				// Traitement de l'emission
                
				// Initialisation du champ de donnees de l'(UDP) PDU a emettre
				sendData = capitalizedSentence.getBytes();
				// Initalisation de l'(UDP)PDU en reponse, donc a l'@IP et n°port
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, port);
				 // Emission de l'(UDP)PDU en reponse
				serverSocket.send(sendPacket);

			}

		} catch (SocketException ex) {
			System.out.println("UDP Port 9876 is occupied.");
			System.exit(1);
		}

	}
}
