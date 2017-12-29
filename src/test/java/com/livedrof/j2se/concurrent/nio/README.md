FileChannel
DatagramChannel
SocketChannel
ServerSocketChannel

Channel
ReadableByteChannel
WritableByteChannel
InterruptibleChannel




exploring scatter/gather I/O, file channels, socket channels, and pipes



Channels provide the ability to perform a single I/O operation across multiple
buffers. This capability is known as scatter/gather I/O (and is also known as
vectored I/O).