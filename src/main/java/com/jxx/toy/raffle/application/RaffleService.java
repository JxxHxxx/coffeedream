package com.jxx.toy.raffle.application;

import com.jxx.toy.raffle.domain.RaffleApplicant;
import com.jxx.toy.raffle.domain.RaffleResult;
import com.jxx.toy.raffle.infra.RaffleApplicantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RaffleService {

    private final RaffleApplicantsRepository raffleApplicantsRepository;

    @Transactional
    public void processRaffleOne(Long raffleId) {
        List<RaffleApplicant> applicants = raffleApplicantsRepository.findByRaffleId(raffleId);
        processRaffleResult(applicants);
    }

    private RaffleApplicant chooseWinner(List<RaffleApplicant> applicants) {
        Random random = new Random();
        int winnerIdx = random.nextInt(0, applicants.size());

        return applicants.get(winnerIdx);
    }

    private void processRaffleResult(List<RaffleApplicant> applicants) {
        RaffleApplicant winner = chooseWinner(applicants);

        applicants.stream()
                .filter(applicant -> applicant.getId() != winner.getApplicantId())
                .forEach(applicant -> applicant.changeRaffleResult(RaffleResult.LOSE));

        winner.changeRaffleResult(RaffleResult.WINNING);
    }


    private void processRaffleResultV2(List<RaffleApplicant> applicants) {
        applicants.forEach(applicant -> applicant.changeRaffleResult(RaffleResult.LOSE));

        RaffleApplicant winner = chooseWinner(applicants);
        winner.changeRaffleResult(RaffleResult.WINNING);
    }
}
