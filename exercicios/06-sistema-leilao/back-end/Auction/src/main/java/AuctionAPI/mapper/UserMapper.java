package AuctionAPI.mapper;

import AuctionAPI.dto.UserDto;
import AuctionAPI.model.UserModel;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static UserModel toMapper(UserDto objetoEntrada) {
        UserModel objetoSaida = new UserModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
