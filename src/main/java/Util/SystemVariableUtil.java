package Util;

import DTO.SystemVariableDTO;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class SystemVariableUtil {
    public Object toType(SystemVariableDTO systemVariable) {
        switch (systemVariable.getSystemVariableType().getName()) {
            case "String":
                return systemVariable.getValue();
            case "Integer":
                return Integer.parseInt(systemVariable.getValue());
            default:
                return systemVariable.getValue();
        }
    }
}