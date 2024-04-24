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

/* table/index.html.twig */
class __TwigTemplate_7d5a1a20a822a53487295682f6f2f122 extends Template
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
        $__internal_5a27a8ba21ca79b61932376b2fa922d2->enter($__internal_5a27a8ba21ca79b61932376b2fa922d2_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "table/index.html.twig"));

        $__internal_6f47bbe9983af81f1e7450e9a3e3768f = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_6f47bbe9983af81f1e7450e9a3e3768f->enter($__internal_6f47bbe9983af81f1e7450e9a3e3768f_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "table/index.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "table/index.html.twig", 1);
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

        echo "Hello TableController!
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
        echo "\t<style>
\t\t.example-wrapper {
\t\t\tmargin: 1em auto;
\t\t\tmax-width: 800px;
\t\t\twidth: 95%;
\t\t\tfont: 18px / 1.5 sans-serif;
\t\t}
\t\t.example-wrapper code {
\t\t\tbackground: #F5F5F5;
\t\t\tpadding: 2px 6px;
\t\t}
\t</style>

\t<div class=\"example-wrapper\">
\t\t<div class=\"example-wrapper\">
\t\t\t<h1>Hello
\t\t\t\t";
        // line 23
        echo twig_escape_filter($this->env, (isset($context["controller_name"]) || array_key_exists("controller_name", $context) ? $context["controller_name"] : (function () { throw new RuntimeError('Variable "controller_name" does not exist.', 23, $this->source); })()), "html", null, true);
        echo "! ✅</h1>
\t\t\t<p>Filas:
\t\t\t\t";
        // line 25
        echo twig_escape_filter($this->env, (isset($context["filas"]) || array_key_exists("filas", $context) ? $context["filas"] : (function () { throw new RuntimeError('Variable "filas" does not exist.', 25, $this->source); })()), "html", null, true);
        echo "</p>
\t\t\t<p>Cols:
\t\t\t\t";
        // line 27
        echo twig_escape_filter($this->env, (isset($context["cols"]) || array_key_exists("cols", $context) ? $context["cols"] : (function () { throw new RuntimeError('Variable "cols" does not exist.', 27, $this->source); })()), "html", null, true);
        echo "</p>

\t\t\t<table class=\"table\">
\t\t\t\t<thead>
\t\t\t\t\t";
        // line 31
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable(range(1, (isset($context["cols"]) || array_key_exists("cols", $context) ? $context["cols"] : (function () { throw new RuntimeError('Variable "cols" does not exist.', 31, $this->source); })())));
        foreach ($context['_seq'] as $context["_key"] => $context["i"]) {
            // line 32
            echo "\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tCol.";
            // line 33
            echo twig_escape_filter($this->env, $context["i"], "html", null, true);
            echo "
\t\t\t\t\t\t</th>
\t\t\t\t\t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['i'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 36
        echo "\t\t\t\t</thead>
\t\t\t\t<tbody>


\t\t\t\t\t";
        // line 40
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["tabla"]) || array_key_exists("tabla", $context) ? $context["tabla"] : (function () { throw new RuntimeError('Variable "tabla" does not exist.', 40, $this->source); })()));
        foreach ($context['_seq'] as $context["_key"] => $context["fila"]) {
            // line 41
            echo "\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t";
            // line 42
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable($context["fila"]);
            foreach ($context['_seq'] as $context["_key"] => $context["col"]) {
                // line 43
                echo "\t\t\t\t\t\t\t\t<td>
\t\t\t\t\t\t\t\t\t<a href=\"";
                // line 44
                echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("app_lucky_number", ["max" => $context["col"]]), "html", null, true);
                echo "\">";
                echo twig_escape_filter($this->env, $context["col"], "html", null, true);
                echo "</a>
\t\t\t\t\t\t\t\t</td>

\t\t\t\t\t\t\t";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['col'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 48
            echo "\t\t\t\t\t\t</tr>
\t\t\t\t\t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['fila'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 50
        echo "\t\t\t\t\t";
        // line 59
        echo "\t\t\t\t</tbody>
\t\t\t</table>


\t\t\tThis friendly message is coming from:
\t\t\t<ul>
\t\t\t\t<li>Your controller at
\t\t\t\t\t<code>C:/Users/mfernandez/Documents/ud8/my_first_symf_project/src/Controller/TableController.php</code>
\t\t\t\t</li>
\t\t\t\t<li>Your template at
\t\t\t\t\t<code>C:/Users/mfernandez/Documents/ud8/my_first_symf_project/templates/table/index.html.twig</code>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>

\t\t";
        // line 75
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
        return "table/index.html.twig";
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
        return array (  198 => 75,  181 => 59,  179 => 50,  172 => 48,  160 => 44,  157 => 43,  153 => 42,  150 => 41,  146 => 40,  140 => 36,  131 => 33,  128 => 32,  124 => 31,  117 => 27,  112 => 25,  107 => 23,  89 => 7,  79 => 6,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Hello TableController!
{% endblock %}

{% block body %}
\t<style>
\t\t.example-wrapper {
\t\t\tmargin: 1em auto;
\t\t\tmax-width: 800px;
\t\t\twidth: 95%;
\t\t\tfont: 18px / 1.5 sans-serif;
\t\t}
\t\t.example-wrapper code {
\t\t\tbackground: #F5F5F5;
\t\t\tpadding: 2px 6px;
\t\t}
\t</style>

\t<div class=\"example-wrapper\">
\t\t<div class=\"example-wrapper\">
\t\t\t<h1>Hello
\t\t\t\t{{ controller_name }}! ✅</h1>
\t\t\t<p>Filas:
\t\t\t\t{{filas}}</p>
\t\t\t<p>Cols:
\t\t\t\t{{cols}}</p>

\t\t\t<table class=\"table\">
\t\t\t\t<thead>
\t\t\t\t\t{% for i in 1..cols %}
\t\t\t\t\t\t<th>
\t\t\t\t\t\t\tCol.{{i}}
\t\t\t\t\t\t</th>
\t\t\t\t\t{% endfor %}
\t\t\t\t</thead>
\t\t\t\t<tbody>


\t\t\t\t\t{% for fila in tabla %}
\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t{% for col in fila %}
\t\t\t\t\t\t\t\t<td>
\t\t\t\t\t\t\t\t\t<a href=\"{{path('app_lucky_number', {'max':col})}}\">{{col}}</a>
\t\t\t\t\t\t\t\t</td>

\t\t\t\t\t\t\t{% endfor %}
\t\t\t\t\t\t</tr>
\t\t\t\t\t{% endfor %}
\t\t\t\t\t{# {% for i in 0..filas-1 %}
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{% for j in 0..cols-1 %}
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                               {{tabla[i][j]}} 
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                </td>
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{% endfor %}
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{% endfor %} #}
\t\t\t\t</tbody>
\t\t\t</table>


\t\t\tThis friendly message is coming from:
\t\t\t<ul>
\t\t\t\t<li>Your controller at
\t\t\t\t\t<code>C:/Users/mfernandez/Documents/ud8/my_first_symf_project/src/Controller/TableController.php</code>
\t\t\t\t</li>
\t\t\t\t<li>Your template at
\t\t\t\t\t<code>C:/Users/mfernandez/Documents/ud8/my_first_symf_project/templates/table/index.html.twig</code>
\t\t\t\t</li>
\t\t\t</ul>
\t\t</div>

\t\t{# <script src='{{ asset('js/inicio.js')}}'></script> #}


\t{% endblock %}
", "table/index.html.twig", "C:\\Users\\a21joaquinle\\Desktop\\workspace\\DUAL\\02_SERVIDOR\\UD8\\Symfony\\Actividad-8.3-sol\\templates\\table\\index.html.twig");
    }
}
