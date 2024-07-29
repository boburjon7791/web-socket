import * as SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';

var socket = new SockJS('/websocket-connection');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {
    console.log('success');
});
