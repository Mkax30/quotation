package cz.mka.quotation.service;

import cz.mka.quotation.model.Quotation;
import cz.mka.quotation.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuotationServiceDefault implements QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Override
    public Quotation createNewQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public Optional<Quotation> findOneQuotation(Long id) {
        return quotationRepository.findById(id);
    }
}
