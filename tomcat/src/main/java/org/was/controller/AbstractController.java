package org.was.controller;

import org.apache.coyote.http11.HttpMethod;
import org.apache.coyote.http11.request.HttpRequest;
import org.was.controller.exception.MethodNotAllowedException;

public abstract class AbstractController implements Controller {

    @Override
    public ResponseResult service(HttpRequest request) {
        HttpMethod method = request.getMethod();
        if (method.equals(HttpMethod.POST)) {
            return doPost(request);
        }
        if (method.equals(HttpMethod.GET)) {
            return doGet(request);
        }

        throw new MethodNotAllowedException(method);
    }

    protected abstract ResponseResult doPost(HttpRequest request);

    protected abstract ResponseResult doGet(HttpRequest request);
}
