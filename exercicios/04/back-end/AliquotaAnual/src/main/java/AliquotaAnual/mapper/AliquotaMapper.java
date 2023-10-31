package AliquotaAnual.mapper;

import AliquotaAnual.dto.AliquotaPostDto;
import AliquotaAnual.dto.AliquotaPutDto;
import AliquotaAnual.model.AliquotaModel;
import org.springframework.beans.BeanUtils;

public class AliquotaMapper {
    public static AliquotaModel toMapper(AliquotaPostDto objetoEntrada) {
        AliquotaModel objetoSaida = new AliquotaModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }

    public static AliquotaModel toMapper(AliquotaPutDto objetoEntrada, AliquotaModel objetoSaida) {
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
