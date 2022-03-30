package com.bloomshoppingcomplex.EndPoint;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bloomshoppingcomplex.Converter.ModelConverter;
import com.bloomshoppingcomplex.DynamoDB.AccountDao;
import com.bloomshoppingcomplex.DynamoDB.Models.Account;
import com.bloomshoppingcomplex.Exceptions.InvalidCharacterException;
import com.bloomshoppingcomplex.Exceptions.UserNotFoundException;
import com.bloomshoppingcomplex.Models.AccountModel;
<<<<<<< HEAD
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
import com.bloomshoppingcomplex.Request.result.UpdateAccountResult;
=======
import com.bloomshoppingcomplex.Models.result.UpdateAccountResult;
import com.bloomshoppingcomplex.Models.Request.UpdateAccountRequest;
>>>>>>> 15cc05d61fcf14dd27fe90316db5287363210205
import com.bloomshoppingcomplex.Util.AccountUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateAccount implements RequestHandler<UpdateAccountRequest, UpdateAccountResult> {
    private final Logger log = LogManager.getLogger();
    private final AccountDao accountDao;

    @Inject
    public UpdateAccount(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UpdateAccountResult handleRequest(UpdateAccountRequest updateAccountRequest, Context context) {
        log.info("Received UpdatedAccountRequest {} ", updateAccountRequest);

        Account updateAccount = accountDao.getAccount(updateAccountRequest.getUserId());

        if (updateAccount == null) {
            throw new UserNotFoundException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getUserId())) {
            throw new InvalidCharacterException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getUsername())) {
            throw new InvalidCharacterException();
        }

        if (!AccountUtils.isValidString(updateAccountRequest.getEmail())) {
            throw new InvalidCharacterException();
        }



        if (!updateAccountRequest.getUserId().equals(updateAccount.getUserId())) {
            throw new UserNotFoundException();
        }

        updateAccount.setUsername(updateAccountRequest.getUsername());
        updateAccount.setEmail(updateAccountRequest.getEmail());

        this.accountDao.saveAccount(updateAccount);

        AccountModel updatedAccount = new ModelConverter().toAccountModel(updateAccount);

        return UpdateAccountResult.builder()
                .withAccountModel(updatedAccount)
                .build();
    }
}
