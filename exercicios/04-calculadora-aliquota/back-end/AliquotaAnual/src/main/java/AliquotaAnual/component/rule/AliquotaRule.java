package AliquotaAnual.component.rule;

import AliquotaAnual.model.AliquotaModel;

public class AliquotaRule {
    public static AliquotaModel calculated(AliquotaModel aliquota) {
        aliquota.setAliquota(getAliquota(aliquota.getRendimentos()));
        aliquota.setParcela(
                getParcela(aliquota.getRendimentos(), aliquota.getAliquota())
        );

        return aliquota;
    }

    public static Double getAliquota(Double rendimentos) {
        if(rendimentos <= 22847.76){
            return 0.0;
        } else if(rendimentos >= 22847.77 && rendimentos <= 33919.80){
            return 7.5;
        } else if(rendimentos >= 33919.81 && rendimentos <= 45012.60){
            return 15.0;
        } else if(rendimentos >= 45012.61 && rendimentos <= 55976.16){
            return 22.5;
        } else {
            return 27.5;
        }
    }

    public static Double getParcela(Double rendimentos, Double aliquota) {
        return ((rendimentos/100) * aliquota);
    }
}
