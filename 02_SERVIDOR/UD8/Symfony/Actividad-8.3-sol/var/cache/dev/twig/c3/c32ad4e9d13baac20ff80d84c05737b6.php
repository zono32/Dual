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

/* nota/list.html.twig */
class __TwigTemplate_8df992353e74962ce20b5e3b67fadaca extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/list.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "nota/list.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "nota/list.html.twig", 1);
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

        echo "Listado de notas
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

        echo "\t

\t<div >
\t\t<div >\t\t

\t\t\t<table class=\"table\">
\t\t\t\t<thead>
\t\t\t\t\t
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tId
\t\t\t\t\t\t</th>
\t\t\t\t\t\t
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tTítulo
\t\t\t\t\t\t</th>
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tDescripción
\t\t\t\t\t\t</th>
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tFecha modificación
\t\t\t\t\t\t</th>
\t\t\t\t
\t\t\t\t</thead>
\t\t\t\t<tbody>


\t\t\t\t\t";
        // line 32
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["notas"]) || array_key_exists("notas", $context) ? $context["notas"] : (function () { throw new RuntimeError('Variable "notas" does not exist.', 32, $this->source); })()));
        $context['_iterated'] = false;
        foreach ($context['_seq'] as $context["_key"] => $context["nota"]) {
            // line 33
            echo "\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t<td>";
            // line 34
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["nota"], "id", [], "any", false, false, false, 34), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t<td>";
            // line 35
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["nota"], "titulo", [], "any", false, false, false, 35), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t<td>";
            // line 36
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["nota"], "descripcion", [], "any", false, false, false, 36), "html", null, true);
            echo "</td>
\t\t\t\t\t\t\t<td>";
            // line 37
            echo twig_escape_filter($this->env, twig_date_format_filter($this->env, twig_get_attribute($this->env, $this->source, $context["nota"], "fechaModificacion", [], "any", false, false, false, 37), "Y-m-d"), "html", null, true);
            echo "</td>
\t\t\t\t\t\t</tr>
\t\t\t\t\t";
            $context['_iterated'] = true;
        }
        if (!$context['_iterated']) {
            // line 40
            echo "\t\t\t\t\t<tr><td> No se han encontrado notas</td></tr>
\t\t\t\t\t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['nota'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 41
        echo "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t</tbody>
\t\t\t</table>


\t\t</div>
\t\t</div>

\t\t";
        // line 50
        echo "

\t";
        
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->leave($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof);

        
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->leave($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof);

    }

    /**
     * @codeCoverageIgnore
     */
    public function getTemplateName()
    {
        return "nota/list.html.twig";
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
        return array (  161 => 50,  151 => 41,  144 => 40,  136 => 37,  132 => 36,  128 => 35,  124 => 34,  121 => 33,  116 => 32,  79 => 6,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Listado de notas
{% endblock %}

{% block body %}\t

\t<div >
\t\t<div >\t\t

\t\t\t<table class=\"table\">
\t\t\t\t<thead>
\t\t\t\t\t
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tId
\t\t\t\t\t\t</th>
\t\t\t\t\t\t
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tTítulo
\t\t\t\t\t\t</th>
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tDescripción
\t\t\t\t\t\t</th>
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tFecha modificación
\t\t\t\t\t\t</th>
\t\t\t\t
\t\t\t\t</thead>
\t\t\t\t<tbody>


\t\t\t\t\t{% for nota in notas %}
\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t<td>{{nota.id}}</td>
\t\t\t\t\t\t\t<td>{{nota.titulo}}</td>
\t\t\t\t\t\t\t<td>{{nota.descripcion}}</td>
\t\t\t\t\t\t\t<td>{{nota.fechaModificacion|date('Y-m-d')}}</td>
\t\t\t\t\t\t</tr>
\t\t\t\t\t{% else %}
\t\t\t\t\t<tr><td> No se han encontrado notas</td></tr>
\t\t\t\t\t{% endfor %}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t</tbody>
\t\t\t</table>


\t\t</div>
\t\t</div>

\t\t{# <script src='{{ asset('js/inicio.js')}}'></script> #}


\t{% endblock %}
", "nota/list.html.twig", "C:\\Users\\a21joaquinle\\Desktop\\workspace\\DUAL\\02_SERVIDOR\\UD8\\Symfony\\Actividad-8.3-sol\\templates\\nota\\list.html.twig");
    }
}
