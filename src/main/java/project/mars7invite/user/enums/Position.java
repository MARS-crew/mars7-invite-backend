package project.mars7invite.user.enums;

public enum Position {
    FRONTEND("프론트엔드"),
    BACKEND("백엔드"),
    DESIGN("디자인"),
    PLANNING("기획"),
    AI("AI");

    private final String label;

    Position(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

