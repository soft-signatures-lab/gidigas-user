package com.enyata.framework.mvvm.ui.deposit;

import com.enyata.framework.mvvm.data.model.api.response.UsersResponse;

public interface DepositNavigator {
    void backArrow();
    void ondepositpin();
    void Depositpin();
    void handleError(Throwable throwable);
    void getUser(UsersResponse resp);
}
