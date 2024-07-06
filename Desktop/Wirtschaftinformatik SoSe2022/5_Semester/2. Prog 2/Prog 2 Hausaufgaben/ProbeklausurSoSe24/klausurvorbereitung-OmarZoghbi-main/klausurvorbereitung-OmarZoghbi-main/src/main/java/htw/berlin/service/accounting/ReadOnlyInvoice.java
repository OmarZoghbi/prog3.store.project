package htw.berlin.service.accounting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public interface ReadOnlyInvoice {

    /**
     * @return das Datum der Rechnungsstellung, ohne Uhrzeit
     */
    LocalDate getDate();

    /**
     * @return Gesamtbetrag der Rechnung inkl. angefallener Mehrwertsteuer.
     */
    BigDecimal getTotalAmount();

    /**
     * @return Nur der Mehrwertsteuer-Anteil des Gesamtbetrags.
     */
    BigDecimal getVatIncluded();
}
