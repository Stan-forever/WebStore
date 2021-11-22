package service.impl;

import Mapper.ProviderMapper;
import POJO.Bill;
import POJO.Provider;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProviderServices;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvidersServiceimpl implements ProviderServices {
    @Autowired
    private ProviderMapper providerMapper;
    public String GetProvider(int id) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        Provider provider=new Provider();
        provider.setId(id);
        provider = providerMapper.getProvider(provider);

        if (provider !=null) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("provider", provider);

        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }

    @Override
    public List<Provider> GetProviderList() {
        List<Provider> list=providerMapper.getProviderlist();
        return  list;
    }

    public String AddProvider(Provider provider) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        List<Provider> list = providerMapper.CheckProvider(provider);
        if (list.size() > 0) {
            success = false;
            msg = "该用户已经存在了，请修改";
        } else {
            int result = providerMapper.InsertProvider(provider);
            if (result > 0) {
                success = true;
                msg = "用户信息添加成功";
            } else {
                success = false;
                msg = "用户信息添加失败";
            }
        }
        map.put("success", success);
        map.put("msg", msg);
        JSONObject json = JSONObject.fromObject(map);
        return json.toString();
    }

    @Override
    public String deleteProvider(Provider provider) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();

        int result = providerMapper.deleteProvider(provider);

        if (result > 0) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }

    public String SearchProvider(String proCode) {
        boolean success = false;
        String msg = "";
        JSONObject map = new JSONObject();
        Provider provider=new Provider();
        provider.setProCode(proCode);
        provider = providerMapper.searchProvider(provider);
        if (provider !=null) {
            success = true;
            msg = "用户信息修改成功";
        } else {
            success = false;
            msg = "用户信息修改失败";
        }
        map.put("success", success);
        map.put("msg", msg);
        map.put("provider", provider);

        JSONObject json = JSONObject.fromObject(map); //将model实体转换成json数据
        return json.toString();//将json数据转换成string类型
    }
}
