module printer {
    requires pointsBuilder;

    exports pro.komdosh.printer.api to bootstrap;
    exports pro.komdosh.printer.implementation to bootstrap;
}
