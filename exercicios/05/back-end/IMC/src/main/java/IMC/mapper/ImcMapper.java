package IMC.mapper;

import IMC.dto.ImcDto;
import IMC.model.ImcModel;
import org.springframework.beans.BeanUtils;

public class ImcMapper {
    public static ImcModel toMapper(ImcDto objetoEntrada) {
        ImcModel objetoSaida = new ImcModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
