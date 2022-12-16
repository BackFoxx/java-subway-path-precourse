package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, List<Section>> sections = new HashMap<>();
    public static final String SECTION_NOT_EXISTING = "노선에 등록되지 않은 출발역과 도착역";

    public static void addSection(Line line, Section section) {
        if (sections.get(line) == null) {
            sections.put(line, new ArrayList<>());
        }
        sections.get(line).add(section);
    }

    public static List<Section> findAll() {
        List<Section> allSections = new ArrayList<>();
        for (List<Section> sections : SectionRepository.sections.values()) {
            allSections.addAll(sections);
        }
        return allSections;
    }

    public static int findMinuteByFirstAndLastStation(Station firstStation, Station lastStation) {
        Section section = findByFirstAndLastStation(firstStation, lastStation);
        return section.getMinute();
    }

    public static int findKmByFirstAndLastStation(Station firstStation, Station lastStation) {
        Section section = findByFirstAndLastStation(firstStation, lastStation);
        return section.getKm();
    }

    private static Section findByFirstAndLastStation(Station firstStation, Station lastStation) {
        return findAll()
                .stream().filter(eachSection -> eachSection.isFirstStation(firstStation) &&
                        eachSection.isLastStation(lastStation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(SECTION_NOT_EXISTING));
    }
}
