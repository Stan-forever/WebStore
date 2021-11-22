package service;

import POJO.Bill;
import POJO.Provider;

import java.util.List;

public interface ProviderServices {
    String GetProvider(int id);
    List<Provider> GetProviderList();
    String AddProvider(Provider provider);
    String deleteProvider(Provider provider);
    String SearchProvider(String proCode);
}
