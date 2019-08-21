module printer {
    requires pointsBuilder;
    requires java.logging;
    exports pro.komdosh.printer.api to bootstrap;
    exports pro.komdosh.printer.implementation to bootstrap;
}
