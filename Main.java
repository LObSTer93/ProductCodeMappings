import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                aggregate(
                        List.of("CVCD", "SDFD", "DDDF", "SDFD"),
                        Map.of(
                                "CVCD", new HashMap<>() {{
                                    put("version", 1);
                                    put("edition", "X");
                                }},
                                "SDFD", new HashMap<>() {{
                                    put("version", 2);
                                    put("edition", "Z");
                                }},
                                "DDDF", new HashMap<>() {{
                                    put("version", 1);
                                }}
                        )
                )
        );
    }

    private static List<Map<String, Object>> aggregate(List<String> productCodes, Map<String, Map<String, Object>> mappings) {
        Map<String, Long> countByProductCodeMap = productCodes.stream()
                .collect(Collectors.groupingBy(productCode -> productCode, Collectors.counting()));
        if (countByProductCodeMap.size() > mappings.size()) {
            String absentProductCodes = countByProductCodeMap.keySet().stream()
                    .filter(productCode -> mappings.get(productCode) == null)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException("No mapping for productCodes: " + absentProductCodes);
        }
        mappings.forEach((key, value) ->
                Optional.ofNullable(countByProductCodeMap.get(key))
                        .ifPresent(productCodeCount -> value.put("quantity", productCodeCount))
        );
        return new ArrayList<>(mappings.values());
    }
}
