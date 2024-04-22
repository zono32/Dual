<?php

namespace App\Repository;

use App\Entity\Autor;
use DateTime;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @extends ServiceEntityRepository<Autor>
 *
 * @method Autor|null find($id, $lockMode = null, $lockVersion = null)
 * @method Autor|null findOneBy(array $criteria, array $orderBy = null)
 * @method Autor[]    findAll()
 * @method Autor[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class AutorRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Autor::class);
    }

    public function findByFechaNac(DateTime $fechaNac):array{
        
        $em = $this->getEntityManager();
        $query = $em->createQuery("SELECT a FROM App\Entity\Autor a WHERE a.fechaNacimiento >= :fechaNac order by a.fechaNacimiento");
        return $query->setParameter("fechaNac", $fechaNac)->getResult();

    }
    public function getAutoresByUnidades(int $unidades): array{
        $em = $this->getEntityManager();
        $query = $em->createQuery("SELECT a FROM App\Entity\Autor a join a.libros li where li.unidadesVendidas > ?1 ");
        return $query->setParameter("unidades", $unidades)->getResult();
    }

    //    /**
    //     * @return Autor[] Returns an array of Autor objects
    //     */
    //    public function findByExampleField($value): array
    //    {
    //        return $this->createQueryBuilder('a')
    //            ->andWhere('a.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->orderBy('a.id', 'ASC')
    //            ->setMaxResults(10)
    //            ->getQuery()
    //            ->getResult()
    //        ;
    //    }

    //    public function findOneBySomeField($value): ?Autor
    //    {
    //        return $this->createQueryBuilder('a')
    //            ->andWhere('a.exampleField = :val')
    //            ->setParameter('val', $value)
    //            ->getQuery()
    //            ->getOneOrNullResult()
    //        ;
    //    }
}
