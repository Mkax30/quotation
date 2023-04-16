package cz.mka.quotation.service;

import cz.mka.quotation.model.Quotation;

import java.util.Optional;

public interface QuotationService {

    Quotation createNewQuotation(Quotation quotation);

    Optional<Quotation> findOneQuotation(Long id);
}
