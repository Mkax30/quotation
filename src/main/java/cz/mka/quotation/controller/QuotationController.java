package cz.mka.quotation.controller;

import cz.mka.quotation.model.Quotation;
import cz.mka.quotation.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/quotations")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping
    public ResponseEntity<Quotation> saveNewQuotation(@RequestBody Quotation quotation) {
        Quotation q = quotationService.createNewQuotation(quotation);
        if (q == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(q, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quotation> findOneQuotation(@PathVariable Long id) {
        Optional<Quotation> q = quotationService.findOneQuotation(id);
        return q.map(quotation -> new ResponseEntity<>(quotation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
