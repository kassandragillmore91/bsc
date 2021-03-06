package com.bloomshoppingcomplex.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
import com.bloomshoppingcomplex.Models.result.UpdateAccountResult;
import com.bloomshoppingcomplex.dependency.DaggerServiceComponent;
import com.bloomshoppingcomplex.dependency.ServiceComponent;

public class UpdateAccountProvider implements RequestHandler<UpdateAccountRequest, UpdateAccountResult> {
    private static final ServiceComponent dagger = DaggerServiceComponent.create();

    public UpdateAccountProvider() {}

    @Override
    public UpdateAccountResult handleRequest(UpdateAccountRequest updateAccountRequest, Context context) {
        return dagger.provideUpdateAccount().handleRequest(updateAccountRequest, context);
    }
}
