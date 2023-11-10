package concepts.poc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author raag
 */
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class JsonToDTOWithInner {

    private List<String> exclusionList;
    private List<String> skipDatatypeCheckColumns;

    @NonNull
    private List<MapperColumn> identifyingColumns;
    private List<MapperColumn> inclusionList;

    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class MapperColumn {
        @Getter
        private String source;
        private String target;
        @Getter
        private double threshold;

        public String getTarget() {
            if(!StringUtils.isBlank(target)) {
                return target;
            }
            return source;
        }
    }
}
