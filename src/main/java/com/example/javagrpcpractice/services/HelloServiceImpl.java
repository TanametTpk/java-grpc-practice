package com.example.javagrpcpractice.services;

import com.example.javagrpcpractice.LoginRequest;
import com.example.javagrpcpractice.LoginResponse;
import com.example.javagrpcpractice.LoginServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class HelloServiceImpl extends LoginServiceGrpc.LoginServiceImplBase {

    @Override
    public void logIn(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        LoginResponse res = null;

        if (check(request.getUsername(), request.getPassword())) {
            res = LoginResponse.newBuilder()
                    .setResponseCode(200)
                    .setMessage("success")
                    .build();
        }else {
            res = LoginResponse.newBuilder().build();
        }

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    private boolean check(String username, String password) {
        return true;
    }
}
