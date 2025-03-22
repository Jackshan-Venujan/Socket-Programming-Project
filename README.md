# Network Monitoring and File Transfer Tool
A comprehensive Java-based application for monitoring network performance and transferring files using socket programming.

## 📋 Overview
This project provides a robust solution for monitoring network metrics and transferring files over a network. It features a user-friendly JavaFX GUI that allows users to:

- Monitor multiple websites/IP addresses simultaneously
- Track key network performance metrics in real-time
- Transfer files between systems with progress tracking
- Visualize network performance through interactive charts

## 🚀 Features
### Network Monitoring
- **Multi-site Monitoring**: Monitor multiple websites or IP addresses concurrently
- **Comprehensive Metrics**: Track latency, DNS resolution time, TCP connection time, TLS handshake time, throughput, packet loss, jitter, and more
- **Real-time Updates**: Continuously updated metrics with visual indicators
- **Performance Alerts**: Automatic alerts for high latency or connection issues
- **Visual Analytics**: Charts for tracking performance trends over time

### File Transfer
- **Client-Server Architecture**: Efficient file transfer using socket programming
- **Progress Tracking**: Real-time progress monitoring during file transfers
- **Network Performance**: Measures transfer speed and latency during file transfers
- **User-friendly Interface**: Simple drag-and-drop interface for file selection
- **Received files will be saved in project folder seperately in "received_files"

### Asynchronous Messaging & Multi-threading
The project includes a robust multi-threaded messaging system that enables real-time communication between multiple clients and a central server:
- **Multi-threaded Server**: Handles multiple client connections simultaneously using Java's threading capabilities
- **Client-Server Architecture**: Supports multiple clients connecting to a central server
- **Real-time Messaging**: Enables instant message exchange between connected clients
- **Connection Monitoring**: Visual representation of client connections over time using JFreeChart
- **Network Scanning**: Utilities for scanning and discovering devices on the network

## 🛠️ Technology Stack
- **Java 17**: Core programming language
- **JavaFX 21**: GUI framework
- **Maven**: Dependency management and build tool
- **Socket Programming**: For network communication and file transfer
- **JFreeChart**: For data visualization
- **Multi-threading**: For concurrent operations

## 🔧 Installation & Setup
### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Maven 3.6.0 or higher

### Building the Project
Clone the repository:
```sh
git clone https://github.com/Jackshan-Venujan/Socket-Programming-Project.git
```

Navigate to the project directory:
```sh
cd Socket-Programming-Project
```

Build the project with Maven:
```sh
mvn clean install
```

### Running from IDE or Command Line
If running directly (not through Maven),You may get this error:
```sh
Error: JavaFX runtime components are missing, and are required to run this application
```
You'll need to add VM options:
```sh
--module-path "/path/to/javafx-sdk-17/lib" --add-modules javafx.controls,javafx.fxml
```

For Windows users:
[Refer this Documentation](https://openjfx.io/openjfx-docs/) 
```sh 
--module-path "\path\to\javafx-sdk-24\lib" --add-modules javafx.controls,javafx.fxml
```

### Running the Application
#### Network Monitoring Tool
```sh
Run MainUI
```

#### Network Scanner
You will automatically get connected IP addresses from running NetworkScanner or you can use any IP address connected with your network.
```sh
Run NetworkScanner in thread folder
```

## 📊 Usage
### Network Monitoring
1. Launch the application
2. Enter a website or IP address in the input field
3. Click "Add Site(s)" to begin monitoring
4. View real-time metrics in the monitoring panel
5. Add multiple sites by separating them with commas

### File Transfer
1. Launch the File Transfer application
2. Enter the IP address of the receiving system
3. Browse and select a file to transfer
4. Click "Send File" to initiate the transfer
5. Monitor the progress and network performance during transfer

## 🧪 Architecture
The project follows a modular architecture with clear separation of concerns:

- **Controller Layer**: Manages the application logic and coordinates between the view and services
- **Service Layer**: Handles network operations, metrics collection, and file transfers
- **View Layer**: Provides the user interface components
- **Model Layer**: Represents the data structures for network metrics and monitoring sites

## 👥 Contributors
- [**Jathurshan Thadshanamoothy**](https://github.com/jathurT)
- [**Pasindu Mallawarachi**](https://github.com/Pasinduimalsha)

## 📄 License
This project is licensed under the MIT License - see the LICENSE file for details.

## 🙏 Acknowledgements
- **University of Ruhuna, Department of Engineering**
- Faculty advisors and mentors who provided guidance.
