package htw.berlin.service.accounting;

import htw.berlin.domain.Burger;
import htw.berlin.service.Observer;
import htw.berlin.ui.ChatbotUI;
import htw.berlin.ui.UserInputWrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class Accounting implements Observer {
    private ChatbotUI ui;
    private UserInputWrapper uiw;

    private Map<Integer, Set<ReadOnlyInvoice>> invoicesByYear = new HashMap<>();

    public Accounting(ChatbotUI ui, UserInputWrapper uiw) {
        this.ui = ui;
        this.uiw = uiw;
        ui.addObserver(this);
    }

    /** nur da, um die Methoden createInvoice und calculateRevenue testen zu können, ohne ChatbotUI mocken zu müssen */
    public Accounting() { }

    @Override
    public void update() {
        Burger order = ui.getLatestOrder();
        LocalDate today = LocalDate.from(LocalDate.now());
        ReadOnlyInvoice invoice = createInvoice(order, today);
        if(invoice != null) {
            int year = invoice.getDate().getYear();
            if (!invoicesByYear.containsKey(year)) invoicesByYear.put(year, new HashSet<>());
            invoicesByYear.get(year).add(invoice);
        }
        uiw.state("Nettoumsatz in " + today.getYear() + " soweit: " + calculateRevenue(invoicesByYear, today.getYear()));
    }

    /**
     * Erzeugt eine Rechnung für die Bestellung eines Burgers.
     * Liegt das Datum der Bestellung zwischen dem 1. Juni 2020 und dem 31. Dezember 2020
     * werden 5% Mehrwertsteuer (engl. VAT) berechnet, ansonsten 7%.
     * @param burger Der Burger, der bestellt wurde und für den eine Rechnung erstellt werden soll
     * @param date Datum der Rechnungsstellung, ohne Uhrzeit.
     * @return Die Rechnung für den übergebenen Burger
     */
    public ReadOnlyInvoice createInvoice(Burger burger, LocalDate date) {
        return null;
    }

    /**
     * Berechnet den Nettoumsatz eines Jahres aus einer gegebenen Menge von Rechnungen.
     * D.h. die Summe aller Rechnungen des spezifizierten Jahres ohne Mehrwertsteuer (engl. VAT).
     * @param allYears Alle Rechnungen, die berücksichtigt werden sollen, aufgelistet nach Jahren
     * @param year Das Jahr für welches der Nettoumsatz berechnet werden soll
     * @return Der aufaddierte Nettoumsatz des spezifizierten Jahres
     */
    public BigDecimal calculateRevenue(Map<Integer, Set<ReadOnlyInvoice>> allYears, Integer year) {
        return new BigDecimal(BigInteger.ZERO);
    }

}
