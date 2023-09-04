package AliquotaAnual.mapper;

import AliquotaAnual.dto.AliquotaDto;
import AliquotaAnual.model.AliquotaModel;
import org.springframework.beans.BeanUtils;

public class AliquotaMapper {
    public static AliquotaModel toMapper(AliquotaDto objetoEntrada) {
        AliquotaModel objetoSaida = new AliquotaModel();
        BeanUtils.copyProperties(objetoEntrada, objetoSaida);

        return objetoSaida;
    }
}
