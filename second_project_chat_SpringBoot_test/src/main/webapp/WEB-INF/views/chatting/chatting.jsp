<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Chat</title>
    <!-- Bootstrap 3.x -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.4.0/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
    
    <style type="text/css">
    #messages {
        height: 200px;
        overflow-y: scroll;
    }
    </style>
    <script>
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/chat-websocket');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/messages', function (message) {
                showMessage(JSON.parse(message.body).content);
            });
        });
    }

    function disconnect() {
        if (stompClient !== null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    function sendMessage() {
        stompClient.send("/app/chat", {}, JSON.stringify({'content': document.getElementById('message').value}));
    }

    function showMessage(message) {
        var messages = document.getElementById('messages');
        var messageElement = document.createElement('li');
        messageElement.appendChild(document.createTextNode(message));
        messages.appendChild(messageElement);
    }
    </script>

</head>
<body>
    <div class="container">
        <h1>WebSocket Chat</h1>
        <div>
            <button onclick="connect()">Connect</button>
            <button onclick="disconnect()">Disconnect</button>
            <input type="text" id="message" placeholder="Enter your message here..."/>
            <button onclick="sendMessage()">Send</button>
        </div>
        <ul id="messages"></ul>
    </div>
</body>
</html>
