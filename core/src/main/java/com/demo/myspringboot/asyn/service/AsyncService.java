package com.demo.myspringboot.asyn.service;

import java.util.concurrent.Future;

public interface AsyncService {

    public Future<String> getDataResult();
}
