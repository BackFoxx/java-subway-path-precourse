package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionRepository {
    private static final Map<Line, List<Section>> sections = new HashMap<>();

    public static void addSection(Line line, Section section) {
        if (sections.get(line) == null) {
            sections.put(line, new ArrayList<>());
        }
        sections.get(line).add(section);
    }
}
