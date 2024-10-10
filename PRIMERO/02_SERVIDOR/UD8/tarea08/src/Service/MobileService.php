<?php

namespace App\Service;

use App\Entity\Mobile;
use App\Repository\MobileRepository;

final class MobileService
{
    
    public function __construct(private MobileRepository $mobileRepository) {
        
    }

    public function create_mobile(Mobile $mobile){
        $this->mobileRepository->save($mobile);
    }


}
