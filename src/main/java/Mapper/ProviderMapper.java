package Mapper;

import POJO.Bill;
import POJO.Provider;
import POJO.User;

import java.util.List;

public interface ProviderMapper {
    Provider getProvider(Provider provider);
    List<Provider> getProviderlist();
    int InsertProvider(Provider provider);
    List<Provider> CheckProvider(Provider provider);
    int deleteProvider(Provider provider);
    Provider searchProvider(Provider provider);
}
