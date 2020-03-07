package com.enyata.framework.mvvm.ui.transactionhistory;

import com.enyata.framework.mvvm.data.model.api.response.UserColorResponse;

public interface TransactionHistoryNavigator {

    void transactionArrow();

    void handleError(Throwable throwable);

    void getUserColor(UserColorResponse userColorResponse);

}
