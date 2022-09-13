package com.king.movieshare.service;


import com.king.movieshare.rpc.Msg;
import com.king.movieshare.rpc.SerServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RpcService {

    public boolean runPyModel(String phoneNum,int k){
        Msg.inMsg request = Msg.inMsg.newBuilder().setPhonenumber(phoneNum).setNum(k).build();
        Msg.outMsg response;
        try {
            Channel channel =  ManagedChannelBuilder.forAddress("localhost", 7777).usePlaintext(true).build();
            SerServiceGrpc.SerServiceBlockingStub blockingStub = SerServiceGrpc.newBlockingStub(channel);
            //调用方法
            response = blockingStub.rec(request);
            if(response.getMsg().equals("finish")){
                return true;
            }
            return false;
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
