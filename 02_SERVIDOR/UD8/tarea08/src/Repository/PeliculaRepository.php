<?php

namespace App\Repository;

use App\Entity\Pelicula;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Exception;

/**
 * @extends ServiceEntityRepository<Pelicula>
 *
 * @method Pelicula|null find($id, $lockMode = null, $lockVersion = null)
 * @method Pelicula|null findOneBy(array $criteria, array $orderBy = null)
 * @method Pelicula[]    findAll()
 * @method Pelicula[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class PeliculaRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry){
        parent::__construct($registry, Pelicula::class);
    }

    public function save(Pelicula  $entity): void
    {

        // $user = $this->getUser();
        // $entity->setUsuario($user);
        $this->getEntityManager()->persist($entity);
        $this->getEntityManager()->flush();
    }


    public function listPelicula($user)
    {        $query = "SELECT a FROM App\Entity\Pelicula a WHERE a.usuario = :usuario ORDER BY a.titulo, a.fechaEstreno ASC";

        $query = $this->getEntityManager()
            ->createQuery($query)
            ->setParameter('usuario', $user);

        return $query->getResult();
    }


    public function deletePelicula($id, $user)
    {

        $pelicula = $this->findPelicula($id);
        $userPeli = $pelicula->getUsuario();

        if ($userPeli->getId() != $user->getId())
            throw new Exception("El usuario autenticado no coincide con el usuario propietario del objeto a eliminar");


        $this->getEntityManager()->remove($pelicula);
        $this->getEntityManager()->flush();
    }



    public function findPelicula($id)
    {
        $query = "SELECT a FROM App\Entity\Pelicula a WHERE a.id = :id";
        $query = $this->getEntityManager()
            ->createQuery($query)
            ->setParameter('id', $id);

        $resp = $query->getResult();

        if (sizeof($resp) == 0)
            throw new Exception("Usuario con id: $id no encontrado");

        return $resp[0];
    }
   
    //     * @return Pelicula[] Returns an array of Pelicula objects
    //     */
 
}
