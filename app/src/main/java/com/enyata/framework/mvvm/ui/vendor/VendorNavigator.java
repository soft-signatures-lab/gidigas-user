package com.enyata.framework.mvvm.ui.vendor;

import com.enyata.framework.mvvm.data.model.api.response.VendorResponse;

public interface VendorNavigator {

    void getVendor(VendorResponse response);
    void handleError(Throwable throwable);

}
