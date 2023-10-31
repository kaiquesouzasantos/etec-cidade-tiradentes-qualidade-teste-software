package IMC.mapper;

import IMC.dto.ImcPostDto;
import IMC.dto.ImcPutDto;
import IMC.model.ImcModel;
import org.springframework.beans.BeanUtils;

public class ImcMapper {
    public static ImcModel toMapper(ImcPostDto objetoEntrada) {
        ImcModel objetoSaida = new ImcModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }

    public static ImcModel toMapper(ImcPutDto objetoEntrada, ImcModel objetoSaida) {
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
