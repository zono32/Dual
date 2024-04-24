<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* nota/detail.html.twig */
class __TwigTemplate_e201d81ccb2f31a2b67c3cd3c1929d5e extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/detail.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/detail.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "nota/detail.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

    }

    // line 3
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Hello NotaController!
";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

    }

    // line 6
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_5a27a8ba21ca79b61932376b2fa922d2 = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 7
        echo "
\t<h2>Información de Nota</h2>

\t";
        // line 10
        if ((array_key_exists("nota", $context) &&  !(null === (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 10, $this->source); })())))) {
            // line 11
            echo "\t\t<table class='table'>
\t\t\t<thead>
\t\t\t\t<tr>
\t\t\t\t\t<th>Id</th>
\t\t\t\t\t<th>Título</th>
\t\t\t\t\t<th>Descripción</th>
\t\t\t\t\t<th>Fecha de modificación</th>
\t\t\t\t</tr>
\t\t\t</thead>
\t\t\t<tbody>

\t\t\t\t<tr>
\t\t\t\t\t<td>
\t\t\t\t\t\t";
            // line 24
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 24, $this->source); })()), "id", [], "any", false, false, false, 24), "html", null, true);
            echo "
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t";
            // line 28
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 28, $this->source); })()), "titulo", [], "any", false, false, false, 28), "html", null, true);
            echo "
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t";
            // line 32
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 32, $this->source); })()), "descripcion", [], "any", false, false, false, 32), "html", null, true);
            echo "
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t";
            // line 36
            echo twig_escape_filter($this->env, twig_date_format_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["nota"]) || array_key_exists("nota", $context) ? $context["nota"] : (function () { throw new RuntimeError('Variable "nota" does not exist.', 36, $this->source); })()), "FechaModificion", [], "any", false, false, false, 36), "Y-m-d"), "html", null, true);
            echo "
\t\t\t\t\t</td>

\t\t\t\t</tr>

\t\t\t</tbody>

\t\t</table>
\t";
        } else {
            // line 45
            echo "\t\t<p>No se ha encontrado información sobre la nota</p>
\t";
        }
        // line 47
        echo "

";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName()
    {
        return "nota/detail.html.twig";
    }

    /**
     * @codeCoverageIgnore
     */
    public function isTraitable()
    {
        return false;
    }

    /**
     * @codeCoverageIgnore
     */
    public function getDebugInfo()
    {
        return array (  148 => 47,  144 => 45,  132 => 36,  125 => 32,  118 => 28,  111 => 24,  96 => 11,  94 => 10,  89 => 7,  79 => 6,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Hello NotaController!
{% endblock %}

{% block body %}

\t<h2>Información de Nota</h2>

\t{% if nota is defined and nota is not null %}
\t\t<table class='table'>
\t\t\t<thead>
\t\t\t\t<tr>
\t\t\t\t\t<th>Id</th>
\t\t\t\t\t<th>Título</th>
\t\t\t\t\t<th>Descripción</th>
\t\t\t\t\t<th>Fecha de modificación</th>
\t\t\t\t</tr>
\t\t\t</thead>
\t\t\t<tbody>

\t\t\t\t<tr>
\t\t\t\t\t<td>
\t\t\t\t\t\t{{nota.id}}
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t{{nota.titulo}}
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t{{nota.descripcion}}
\t\t\t\t\t</td>

\t\t\t\t\t<td>
\t\t\t\t\t\t{{nota.FechaModificion|date('Y-m-d')}}
\t\t\t\t\t</td>

\t\t\t\t</tr>

\t\t\t</tbody>

\t\t</table>
\t{% else %}
\t\t<p>No se ha encontrado información sobre la nota</p>
\t{% endif %}


{% endblock %}
", "nota/detail.html.twig", "C:\\Users\\mfernandez\\Documents\\ud8\\EjemploLibros\\Ejemplo_libros\\templates\\nota\\detail.html.twig");
    }
}
