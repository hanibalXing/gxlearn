package com.nio.oldio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author gx
 * @ClassName: OldIoServer
 * @Description: java类作用描述
 * @date 2019/4/2 0:11
 * @Version: 1.0
 * @since
 */
@Slf4j
public class OldIoServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService =new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),new ThreadPoolExecutor.AbortPolicy());
        final ServerSocket serverSocket=new ServerSocket(10000);
        while (true)
        {
            Socket accept = serverSocket.accept();
            executorService.execute(()->{
                handle(accept);
            });
        }
    }

    private static void handle(Socket accept) {
        byte[] bytes=new byte[1024];
        try {
            InputStream inputStream = accept.getInputStream();

            while (true) {
                int read = inputStream.read(bytes);
                if (-1!=read) {
                    System.out.println(new String(bytes, 0, read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
